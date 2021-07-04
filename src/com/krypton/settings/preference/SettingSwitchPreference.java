/*
 * Copyright (C) 2021 AOSP-Krypton Project
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
 * limitations under the License
 */

package com.krypton.settings.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.preference.SwitchPreference;

import com.android.settings.R;
import com.krypton.settings.Utils;

public class SettingSwitchPreference extends SwitchPreference {

    private final Context mContext;
    private final String mSettingKey, mSettingNamespace;
    private final int mSettingDefault;

    public SettingSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        final TypedArray typedArray = mContext.getResources().obtainAttributes(attrs, R.styleable.SettingPreferenceBaseAttrs);
        mSettingKey = typedArray.getString(R.styleable.SettingPreferenceBaseAttrs_settingKey);
        mSettingNamespace = typedArray.getString(R.styleable.SettingPreferenceBaseAttrs_settingNamespace);
        mSettingDefault = typedArray.getInteger(R.styleable.SettingPreferenceBaseAttrs_settingDefault, 0);
        typedArray.recycle();
        setChecked(isChecked());
    }

    @Override
    public boolean isChecked() {
        return Utils.getSettingBoolean(mContext,
            mSettingNamespace, mSettingKey, mSettingDefault);
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        Utils.applySetting(mContext, mSettingNamespace, mSettingKey, checked);
    }
}
