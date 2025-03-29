# nixNightVision

**nixNightVision** is a flexible and user-friendly plugin designed to enhance the gameplay experience by allowing players to toggle Night Vision effects with ease. It offers customizable messages, PlaceholderAPI integration, and commands with permission control, making it ideal for servers that need versatile Night Vision functionality.

---

## **Key Features**
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

## **Requirements**
- **Java Version**: Java 8 or higher  
- **Minecraft Server Versions**: Spigot/Paper servers between **1.13 and 1.21**

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

## **Customization via `config.yml`**
The plugin offers extensive configuration options to tailor its messages and behavior.

### **Example Configuration Options**
- Custom prefix for plugin messages:
  ```yaml
  prefix: '&8[&aNightVision&8]'
  ```
- Toggle messages for players and admins:
  ```yaml
  messages:
    notification-enabled: '{PREFIX} &aNight vision is now enabled!'
    notification-disabled: '{PREFIX} &cNight vision is now disabled!'
    night-vision-error-no-player: '{PREFIX} &cPlayer "{PLAYER}" was not found or is offline.'
  ```
- On-join automatic Night Vision:
  ```yaml
  on-join-nightvision: true
  ```

---

This plugin is maintained with ease-of-use in mind, while offering powerful features for players and admins alike.
### **Need Help or Found a Bug?**  
Encountered an issue or need assistance?  
- Report problems directly on our [GitHub Issue Tracker](https://github.com/Nixoly/nixNightVision/issues).  
- Join our [Discord Server](https://discord.gg/eGMHpDPzPJ) for live support and community discussions.  
