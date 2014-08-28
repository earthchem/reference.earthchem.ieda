#!/bin/sh
git filter-branch -f --env-filter '
an="$GIT_AUTHOR_NAME"
am="$GIT_AUTHOR_EMAIL"
cn="$GIT_COMMITTER_NAME"
cm="$GIT_COMMITTER_EMAIL"
if [ "$GIT_COMMITTER_EMAIL" = "song@ldeo.columbia.edu" ]
then
GIT_COMMITTER_EMAIL=lulin.song@gmail.com
export GIT_COMMITTER_EMAIL
fi
if [ "$GIT_AUTHOR_EMAIL" = "song@ldeo.columbia.edu" ]
then
GIT_AUTHOR_EMAIL=lulin.song@gmail.com
export GIT_AUTHOR_EMAIL
fi
if [ "$GIT_AUTHOR_EMAIL" = "info@petdb.org" ]
then
GIT_AUTHOR_EMAIL=lulin.song@gmail.com
export GIT_AUTHOR_EMAIL
fi
if [ "$GIT_COMMITTER_EMAIL" = "info@petdb.org" ]
then
GIT_COMMITTER_EMAIL=lulin.song@gmail.com
export GIT_COMMITTER_EMAIL
fi
' -- --all
