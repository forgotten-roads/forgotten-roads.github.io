BLOG_DIR = $(ROOT_DIR)/blog
CSS_DIR = $(BLOG_DIR)/css
REPO = $(shell git config --get remote.origin.url)
LOCAL_BLOG_HOST = localhost
LOCAL_BLOG_PORT = $(lastword $(shell grep dev-port project.clj))
LESS_DIR = src/less
COLOUR_THEME = frmx
AWS_BUCKET = forgotten.roads.mx
AWS_BLOG_BUCKET = $(AWS_BUCKET)/blog

blog: blog-clean blog-local

blog-clean:
	@echo "\nCleaning old blog build ..."

blog-data:
	@rm -rf blog/data
	@cp -r resources/data blog/

blog-pre:
	@echo "\nBuilding blog ...\n"
	@$(MAKE) blog-data

blog-css:
	@lessc $(LESS_DIR)/styles-$(COLOUR_THEME).less $(CSS_DIR)/styles.css

blog-clojure:
	@frmx gen
	@echo

blog-local: blog-pre blog-css blog-clojure

blog-dev-gen: blog
	@echo "\nRunning blog server from generated static content ..."
	@echo "URL: http://$(LOCAL_BLOG_HOST):$(LOCAL_BLOG_PORT)/blog"
	@lein simpleton $(LOCAL_BLOG_PORT) file :from $(ROOT_DIR)

blog-dev:
	@echo "\nRunning blog server from code ..."
	@echo "URL: http://$(LOCAL_BLOG_HOST):$(LOCAL_BLOG_PORT)/blog"
	@frmx run

.PHONY: blog

publish-verifications-aws:
	@aws --profile=frmx s3 \
		cp resources/site-verification/f.r.mx/* \
		s3://$(AWS_BUCKET)/
	@aws --profile=frmx s3 \
		cp resources/site-verification/blog.f.r.mx/* \
		s3://$(AWS_BLOG_BUCKET)/

publish-redirects-aws:
	aws --profile=frmx s3 \
		sync resources/site-redirects/f.r.mx/ \
		s3://$(AWS_BUCKET)/

publish-robots-aws:
	@aws --profile=frmx s3 \
		cp resources/robots.txt \
		s3://$(AWS_BUCKET)/

publish-data-aws:
	aws --profile=frmx s3 \
		sync resources/data/ \
		s3://$(AWS_BLOG_BUCKET)/data/

publish-aws:
	@aws --profile=frmx s3 cp blog/ s3://$(AWS_BLOG_BUCKET)/ --recursive

publish-aws-modified:
	@for f in `git status|grep modified|awk '{print $$2}'|egrep '^blog/'` ; do \
		aws --profile=frmx s3 \
			cp "$$f" s3://$(AWS_BLOG_BUCKET)`echo $$f|sed -e 's/^blog\///'` ; \
	done

publish-aws-committed:
	@for f in `git log --numstat HEAD^.. blog|awk '{print $$3}'|egrep '^blog'` ; do \
		aws --profile=frmx s3 \
			cp "$$f" s3://$(AWS_BLOG_BUCKET)`echo $$f|sed -e 's/^blog\///'` ; \
	done

sync-aws: commit-content
	@aws --profile=frmx s3 sync blog/ s3://$(AWS_BLOG_BUCKET)/

commit-content:
	@git commit blog -m "Regen'ed content." || echo "Nothing to commit."
	@git push origin master || echo "Nothing to push."
