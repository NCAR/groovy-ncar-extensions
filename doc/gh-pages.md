# Github pages documentation

The API documentation is built from groovydoc comments
via the gradle task `groovydoc` into the directory `gh-pages`
and the Github branch `gh-pages`. This is accessible at:

    https://ncar.github.io/groovy-ncar-extensions/

## Simple setup

Skip the long discussion below, and just checkout
a copy of the gh-pages branch into a gh-pages subdirectory
in the main clone top-level.

    git clone -b gh-pages git@github.com:NCAR/groovy-ncar-extensions.git gh-pages
    cd gh-pages
    git remote set-head origin gh-pages
    git remote set-branches origin gh-pages

During development, when a new version is deployed,
also run the Gradle task `gh-pages` to generate new docs.
Then change to the gh-pages subdir and add/commit the changes.
Finally, push gh-pages direct to github.

(Submodules may be explored in the future, but for the
moment we will keep a simpler deployment workflow.)

We recommend that you do not checkout the gh-pages branch
in the main level of your repo. Deleting and creating so many
files may cause performance issues or unintended side-effects.

## Intro

The workflow is based on this author's personal site,
documented in that [blog](http://haxx.sinequanon.net/2016/08/gh-pages-setup/).
The basic process is repeated here, but may actually
be more complicated than necessary. It is hard to get
changes from github pulled into the gh-pages branch
of the main checkout and then into the gh-pages subdir.

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
