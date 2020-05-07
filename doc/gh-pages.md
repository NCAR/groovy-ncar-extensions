# Github pages documentation

The API documentation is built from groovydoc comments
via the gradle task `groovydoc` into the directory `gh-pages`
and the Github branch `gh-pages`. This is accessible at:

    https://ncar.github.io/groovy-ncar-extensions/

The workflow is based on this author's personal site,
documented in that [blog](http://haxx.sinequanon.net/2016/08/gh-pages-setup/).
The basic process is repeated here.

## Setup

Github should already be setup. As a new documentation developer,
you need to setup the `gh-pages` directory as a clone of the
`gh-pages` branch. From the top-level directory of your clone
of this repository, run the following commands:

    git clone -b gh-pages . gh-pages
    cd gh-pages
    git remote set-head origin gh-pages
    git remote set-branches origin gh-pages
    cd ..
    git config push.default matching

## Workflow

Updating the code and the docs are separate operations.
Commit and merge all your code and groovydoc-comment changes
with normal development workflows.
When a Github "release" is made (just a git tag of your version),
then also update the docs.

First, be sure your repo is checked-out to the latest tag or version
that is being documented. You may optionally run the gradle task
`groovydoc` and review the output.
Then run the gradle task `gh-pages`, commit and push:

    gradle gh-pages
    cd gh-pages
    git add .
    git commit -a
    git push
    cd ..
    git push

New version links are automatically appended to `gh-pages/README.md`.
If something goes wrong, just manually edit as needed.
