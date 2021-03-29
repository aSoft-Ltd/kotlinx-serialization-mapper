# 0.0.60 : 2021.03.29

- Updated kotlin from 1.4.21 to 1.4.31
- Updated gradle from 6.7.1 to 6.8.1
- Bumped serialization from 1.0.1 to 1.1.0
- Removed android gradle plugin
- Updated build script to use macos instead of ubuntu for building
- Added linux, macos,ios and tvos targets

# 0.0.4 : 2020.12.24

- Enabled serialization and deserialization of null values as well

# 0.0.3 : 2020.12.24

- Updated to kotlin 1.4.21
- Upgraded to gradle 6.7.1
- Added tests to cover nullable map values uses cases

# 0.0.2: 2020.12.13

## Bug Fixes

- Stabilized data types

## New Features

- Added a `fun Mapper(from: Mapper, builder: JsonConfig.()->Unit)`

# 0.0.1

## Availability

- Published to maven central

## Build Src

- Updated to gradle version 6.7

## New Features

- Added `Mapper.decodeFromString()`
- Added `Mapper.encoderToString()`

## Documentation

- Update readme

## Tests

- Added tests