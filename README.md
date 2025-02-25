# TimeSyncBridge

TimeSyncBridge is a Bukkit/Spigot plugin that receives time data from TimeSync (Velocity) and applies it to worlds in the Minecraft server. It also provides placeholders via PlaceholderAPI to display time and date in various formats.

## Features
- Receives time data (`ticks`) from TimeSync (Velocity).
- Applies time to all worlds on the server.
- Provides placeholders via PlaceholderAPI.

## Installation
1. Download the `.jar` file from [releases](https://github.com/khisabkurniawn/TimeSyncBridge/releases).
2. Place the `.jar` file in the `plugins` folder of your Bukkit/Spigot server.
3. Ensure PlaceholderAPI is installed if you want to use placeholders.
4. Restart the server.

## Usage
Once installed, the plugin will automatically receive time data from TimeSync (Velocity). You can use the following placeholders in plugins that support PlaceholderAPI:

- `%timesync_time_24h%`: Displays time in 24-hour format.
- `%timesync_time_12h%`: Displays time in 12-hour format.
- `%timesync_time_ampm%`: Displays the period of the day (AM or PM) based on the current time.
- `%timesync_date%`: Displays the current date.
- `%timesync_date_ordinal%`: Displays the current day of the month with an ordinal suffix.
- `%timesync_day_of_year%`: Displays the current day of the year.
- `%timesync_month%`: Displays the current month as a number.
- `%timesync_year%`: Displays the current year.
- `%timesync_season%`: Displays the current season based on the month.
- `%timesync_dayparts%`: Displays a symbol representing the current part of the day.


## Support
If you encounter any issues or have questions, please open an [issue](https://github.com/khisabkurniawn/TimeSyncBridge/issues) on GitHub.

## License
This project is licensed under the [Apache](https://github.com/khisabkurniawn/TimeSyncBridge?tab=Apache-2.0-1-ov-file).