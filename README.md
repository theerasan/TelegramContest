## Ta Legram for the Android Contest 2025, Round 1.
### Say Hi
I'm Theerasan Tonthongkam, but you can call me Ta. I'm an Android engineer with over 10 years of experience, based in Bangkok, Thailand.
I joined this contest driven by passion and enthusiasm.

#### Learn more about me
1. [LinkedIn](https://www.linkedin.com/in/theerasan-tonthongkam/)
2. [Resume](https://docs.google.com/document/d/1PjG_kUpry4AqWKVEw0VV02HCih3igUJII3NR1A8qXlI/)

#### Proudly Present Projects
1. [Honest](https://play.google.com/store/apps/details?id=com.honestbank.android)
2. [Eatigo](https://play.google.com/store/apps/details?id=com.eatigo)
3. [We Comics (former OokbeeComics)](https://play.google.com/store/apps/details?id=com.ookbee.ookbeecomics.android)
4. [AmPos](https://play.google.com/store/apps/details?id=com.ampos.bluecrystal)
---
### Why Ta legram
I combined my name, Ta, with Telegram to create the name of my app: **Ta-legram**. In Thai, **_Ta-le_** means "ocean," which is why I chose a wave as the app icon.

### What I've updated in the code base?
#### Profile activity
1. I extracted all the magic numbers I used into variables. (I didn’t extract all of them to avoid excessive changes.)
2. I reordered the views and view inflation to properly layer the avatar, gift background, drop effects, and blur image.
3. I recalculated the X and Y positions of each component to ensure smooth transitions.
4. I created the buttons under the avatar based on priority. As a result, they may not exactly align with the design, which also doesn’t showcase other profile types such as groups, channels, etc.
   - Floating buttons
   - Displayed menu items (Edit, Call, Video Call)
   - Additional menu
   - The button section only contains up to 4 items
   - When all 4 buttons are shown, the menu items and floating button will be hidden to avoid duplicated actions
5. I added auto-expand and auto-collapse behavior for the top bar:
   - If the avatar is scrolled more than 20% out of view and the user releases the scroll, the top bar will collapse.
   - On the other hand, if the avatar is visible at 80% or more of its height when the scroll is released, the top bar will expand.

#### Profile pattern
1. I created a new method specifically for this case, so it won’t affect other screens.
2. I also added a tolerance value for each emoji — the one with the least tolerance will move to the avatar first.

#### Profile gift
1. I reworked this to avoid using hardcoded indices. Instead, I applied the same concept used in the _**Profile Pattern**_, with predefined points and tolerance values.

#### Profile drop effect
1. I draw the canvas drop effect by calculating each path based on the user's movement.
2. With this approach, there's no need to introduce new assets or libraries.

#### Chat activity
1. I hid the profile icon so that during the transition from the chat activity to the profile activity, the avatar moves down from the top. This creates a smoother transition between screens.

#### Resouces and Configulations
1. I updated the default icon to a wave icon.
2. I named the app "Ta-legram", and "B - Ta-legram" for the beta version.
3. The app still supports switching to the existing predefined icons.

---

## Telegram messenger for Android

[Telegram](https://telegram.org) is a messaging app with a focus on speed and security. It’s superfast, simple and free.
This repo contains the official source code for [Telegram App for Android](https://play.google.com/store/apps/details?id=org.telegram.messenger).

## Creating your Telegram Application

We welcome all developers to use our API and source code to create applications on our platform.
There are several things we require from **all developers** for the moment.

1. [**Obtain your own api_id**](https://core.telegram.org/api/obtaining_api_id) for your application.
2. Please **do not** use the name Telegram for your app — or make sure your users understand that it is unofficial.
3. Kindly **do not** use our standard logo (white paper plane in a blue circle) as your app's logo.
3. Please study our [**security guidelines**](https://core.telegram.org/mtproto/security_guidelines) and take good care of your users' data and privacy.
4. Please remember to publish **your** code too in order to comply with the licences.

### API, Protocol documentation

Telegram API manuals: https://core.telegram.org/api

MTproto protocol manuals: https://core.telegram.org/mtproto

### Compilation Guide

**Note**: In order to support [reproducible builds](https://core.telegram.org/reproducible-builds), this repo contains dummy release.keystore,  google-services.json and filled variables inside BuildVars.java. Before publishing your own APKs please make sure to replace all these files with your own.

You will require Android Studio 3.4, Android NDK rev. 20 and Android SDK 8.1

1. Download the Telegram source code from https://github.com/DrKLO/Telegram ( git clone https://github.com/DrKLO/Telegram.git )
2. Copy your release.keystore into TMessagesProj/config
3. Fill out RELEASE_KEY_PASSWORD, RELEASE_KEY_ALIAS, RELEASE_STORE_PASSWORD in gradle.properties to access your  release.keystore
4.  Go to https://console.firebase.google.com/, create two android apps with application IDs org.telegram.messenger and org.telegram.messenger.beta, turn on firebase messaging and download google-services.json, which should be copied to the same folder as TMessagesProj.
5. Open the project in the Studio (note that it should be opened, NOT imported).
6. Fill out values in TMessagesProj/src/main/java/org/telegram/messenger/BuildVars.java – there’s a link for each of the variables showing where and which data to obtain.
7. You are ready to compile Telegram.

### Localization

We moved all translations to https://translations.telegram.org/en/android/. Please use it.
