/*
 * Copyright (C) 2013 The OmniROM Project
 *               2021 AOSP-Krypton Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.krypton.settings.fragment;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private final Drawable mIcon;
    private final String mAppName, mPackageName;

    public AppInfo(Drawable icon, CharSequence appName, String packageName) {
        mIcon = icon;
        mAppName = appName.toString();
        mPackageName = packageName;
    }

    public Drawable getIcon() {
        return mIcon;
    }

    public String getAppName() {
        return mAppName;
    }

    public String getPackageName() {
        return mPackageName;
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj) &&
            this.mPackageName.equals(((AppInfo) obj).mPackageName);
    }

    public int compare(AppInfo appInfo) {
        if (appInfo == null) {
            return -1;
        }
        return this.mAppName.compareToIgnoreCase(
            appInfo.mAppName);
    }

    public boolean filter(CharSequence query) {
        if (query == null) {
            return true;
        }
        return this.mAppName.toLowerCase().contains(
            query.toString().toLowerCase());
    }
}
