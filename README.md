# Project Title
# Coding challenge

There is a publicly available API for the webcomic XKCD – [https://xkcd.com/json.html](https://xkcd.com/json.html)

And an RSS feed for PDL: [http://feeds.feedburner.com/PoorlyDrawnLines](http://feeds.feedburner.com/PoorlyDrawnLines)

## Description
Create a RESTful service that pulls last 10 strips from each and combines them in a single json feed (20 recent entries in total). The response should contain the following data for each entry:

- picture url
- title / description
- web url for browser view
- publishing date

Sort the resulting feed by publishing date from recent to older.

## Getting Started

### Dependencies

No dependency

### Installing

* copy  comic-strips-app:1.0-SNAPSHOT file from https://github.com/ensiehrahbar/codingchallenge

### Executing program
Run
* docker run -p 8080:8181 -t comic-strips-app:1.0-SNAPSHOT

* http://localhost:8080





