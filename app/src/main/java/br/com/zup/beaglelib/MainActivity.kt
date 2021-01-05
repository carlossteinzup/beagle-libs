/*
 *  Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package br.com.zup.beaglelib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.android.utils.newServerDrivenIntent
import br.com.zup.beagle.android.utils.toView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.ServerDrivenActivity
import br.com.zup.beaglescaffold.R
import br.com.zup.beaglescaffold.initialConfig.BeagleDeclarativeSample
import br.com.zup.beaglescaffold.initialConfig.BeagleIntent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declarative screen
        //server_driven_content_layout.addView((BeagleDeclarativeSample.screen).toView(this))

        // Config with beagle defaults - Server-driven activity
        //val intent = this.newServerDrivenIntent<ServerDrivenActivity>(ScreenRequest("http://10.0.2.2:8080/text"))
        //startActivity(intent)

        //Config with Scaffold - Server-driven activity
        startActivity(BeagleIntent(this).toSample())
    }
}