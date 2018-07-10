/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.unknown.cheaperapp.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;


public class callgridviewadapter extends ArrayAdapter<String> {
    private int backgrouncolor;


    public callgridviewadapter(Context context, ArrayList<String> words) {
        super(context, 0, words);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.callbutton, parent, false);
        }
        String scurentstore=getItem(position);
      TextView storename = (TextView) listItemView.findViewById(R.id.storename);
        storename.setText(scurentstore.toString());

            return listItemView;
        }
    }
