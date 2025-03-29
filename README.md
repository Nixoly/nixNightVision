# nixNightVision

![Java](https://img.shields.io/badge/Java-8+-green?style=plastic) ![Minecraft](https://img.shields.io/badge/Minecraft-1.13--1.21-blue?style=plastic)

---

## **Features**
- **Night Vision Toggle for Players**:  
  Players can activate or deactivate Night Vision for themselves or other players using simple commands.

- **Admin Controls**:  
  Allows server administrators to configure plugin behavior, toggle Night Vision for players, and manage permissions efficiently.

- **Customizable Messages**:  
  All plugin messages are fully customizable via the configuration file (`config.yml`), allowing for server-specific formatting.

- **Permissions-Based Access**:  
  Granular permissions control who can toggle Night Vision for themselves, other players, or reload the plugin.

- **Placeholders Support**:  
  Seamless integration with PlaceholderAPI to show Night Vision status dynamically using the `%nightvision_status%` placeholder.

- **On-Join Night Vision**:  
  Automatically enable Night Vision for players upon joining the server if configured in `config.yml`.

- **Reloadable Configuration**:  
  Easily reload plugin settings without restarting the server using the `/nv reload` command.

---

## **Commands**
| Command                      | Description                                                             | Permission              |
|------------------------------|-------------------------------------------------------------------------|-------------------------|
| `/nv`                        | Toggles Night Vision for yourself.                                      | `nightvision.use`       |
| `/nv <player>`               | Toggles Night Vision for another player.                                | `nightvision.player`    |
| `/nv help`                   | Displays a helpful list of plugin commands.                            | `nightvision.help`      |
| `/nv reload`                 | Reloads the plugin's configuration.                                    | `nightvision.reload`    |

---

## **Permissions**
| Permission                  | Description                                           | Default |
|-----------------------------|------------------------------------------------------|---------|
| `nightvision.use`           | Allows toggling Night Vision for yourself.           | OP      |
| `nightvision.player`        | Allows toggling Night Vision for other players.      | OP      |
| `nightvision.help`          | Allows access to the help menu.                      | OP      |
| `nightvision.reload`        | Allows reloading of the plugin configuration.        | OP      |

---

## **Optional Dependencies**
- **PlaceholderAPI**:
  - Enables `%nightvision_status%` placeholder support.
  - Displays if a player's Night Vision is `enabled` or `disabled`.

---

### **Need Help or Found a Bug?**  
Encountered an issue or need assistance?  
- Report problems directly on our [GitHub Issue Tracker](https://github.com/Nixoly/nixNightVision/issues).  
- Join our [Discord Server](https://discord.gg/eGMHpDPzPJ) for live support and community discussions.  
