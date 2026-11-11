# Bloodthirsty Spear Minecraft Plugin

Bloodthirsty Spear is a Paper Minecraft plugin that prevents hunger exhaustion while a player holds a spear enchanted with Lunge in either hand. It listens for player exhaustion events and cancels them while that qualifying spear is held.

## Install

1. Build the project with Java 21 and Maven by running `mvn package`.
2. Copy `target/plugin.jar` into your Paper server’s `plugins` folder.
3. Restart the server.

## Use

1. Give a player a spear enchanted with Lunge.
2. Hold that spear in either hand.
3. While holding it, the plugin cancels the player’s exhaustion events. This applies to exhaustion from any source, not only spear lunges.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/62b4567a-3a28-47e2-9e95-9252564a62ae?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=62b4567a-3a28-47e2-9e95-9252564a62ae
