#!/usr/bin/env bash
# One-command setup for webScraper_java.
# Builds the project and produces a runnable fat jar at target/webscraper.jar.
set -euo pipefail
cd "$(dirname "$0")"

echo "==> Building with Maven (downloads dependencies, compiles, packages)..."
mvn -q package

echo
echo "Setup complete. Run the app with:"
echo "  java -jar target/webscraper.jar"
echo
echo "Or use the CLI scraper directly:"
echo "  java -cp target/webscraper.jar com.pranavamk.webscraper.WebScraper https://example.com"
