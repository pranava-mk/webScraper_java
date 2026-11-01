# 🕷️ Web Scraper (Java)

> A small Java desktop app that scrapes every link off a page and saves them to CSV.

Uses [Jsoup](https://jsoup.org/) for HTML parsing and a Swing GUI for input,
built with Maven.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Maven](https://img.shields.io/badge/build-Maven-C71A36)
![Jsoup](https://img.shields.io/badge/deps-Jsoup-informational)
![License](https://img.shields.io/badge/license-none%20specified-lightgrey)

---

## ✨ What it does

Point it at any URL and it extracts every `<a href>` on the page, resolves
them to absolute URLs, and writes them to a CSV named after the site's domain
(e.g. `example.com.csv`). Available as both a GUI and a CLI.

## 🚀 Getting Started

One command builds everything:

```bash
./setup.sh
```

This runs `mvn package`, downloading Jsoup and producing a runnable shaded
jar at `target/webscraper.jar`.

### Requirements

- JDK 17+
- Maven 3.6+

## 🖥️ Usage

**GUI** — enter a URL and click "Scrape":

```bash
java -jar target/webscraper.jar
```

**CLI** — scrape directly from the command line:

```bash
java -cp target/webscraper.jar com.pranavamk.webscraper.WebScraper https://example.com
```

Either way, the output CSV lands in the current directory, one absolute URL
per line for every link found.

## 🗂️ Project Structure

```
webScraper_java/
├── pom.xml
├── setup.sh
└── src/main/java/com/pranavamk/webscraper/
    ├── WebScraper.java       # scraping logic (Jsoup fetch + parse + CSV write)
    └── WebScraperGui.java    # Swing GUI wrapper around WebScraper
```

## 🧭 Why Java?

Python is the more common scraping choice, but Java is solid too — fast,
strongly typed, and [Jsoup](https://jsoup.org/) makes HTML parsing
straightforward. This was a project to get hands-on with Java + a real
third-party library + Maven, end to end.

## 🛠️ Applications

Useful for quick link audits: digging through a site's structure, finding
outbound links for research, or spotting unexpected endpoints as a
lightweight first pass before deeper security testing.

## ⚠️ Limitations

This is a learning project, not a production crawler:

- Single page only — it does not recurse into the links it finds
- No JavaScript rendering — SPA pages that build links client-side won't
  expose them to Jsoup, since it only sees the initial HTML response
- No rate limiting, retries, or robots.txt handling

## 📦 Deployment

This is a **desktop application**, not a web app — there's no hosted link.
Running it means building the jar locally (`./setup.sh`) and launching it,
either as the GUI or from the CLI.
