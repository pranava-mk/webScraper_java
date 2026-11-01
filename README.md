# Web Scraper (Java)

A small Java desktop app that scrapes every link off a given webpage and saves them to a CSV file.
Uses [Jsoup](https://jsoup.org/) for HTML parsing and a Swing GUI for input.

## Why Java?

Python is the more common choice for scraping, but Java is a solid option too: it's
fast, strongly typed, and [Jsoup](https://jsoup.org/) makes HTML parsing straightforward.
This was a small project to get hands-on with Java + a real third-party library + Maven.

## Requirements

- JDK 17+
- Maven 3.6+

## Build

```bash
mvn package
```

This produces a runnable shaded jar at `target/webscraper.jar`.

## Run

**GUI** (enter a URL and click "Scrape"):

```bash
java -jar target/webscraper.jar
```

**CLI** (scrape directly from the command line):

```bash
java -cp target/webscraper.jar com.pranavamk.webscraper.WebScraper https://example.com
```

Either way, the output is a CSV named after the site's domain (e.g. `example.com.csv`)
in the current directory, containing one absolute URL per line for every `<a href>` on the page.

## How it works

- `WebScraper.java` — the actual scraping logic: fetches the page with Jsoup, selects all
  `a[href]` elements, resolves them to absolute URLs, and writes them to a CSV.
- `WebScraperGui.java` — a Swing window that takes a URL from the user and delegates to
  `WebScraper.main(...)`.

## Applications

Useful for quick link audits — digging through a site's structure, finding all outbound
links for research, or spotting unexpected endpoints as a lightweight first pass before
deeper security testing.

## Limitations

This is a learning project, not a production crawler:

- Single page only — it does not recurse into the links it finds.
- No JavaScript rendering — pages that build their nav/links client-side (SPAs) won't
  expose those links to Jsoup, since it only sees the initial HTML response.
- No rate limiting, retries, or robots.txt handling.
