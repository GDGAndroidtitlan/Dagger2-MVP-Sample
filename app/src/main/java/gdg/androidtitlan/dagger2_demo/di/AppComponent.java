/**
 * Copyright 2015 Erik Jhordan Rey.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gdg.androidtitlan.dagger2_demo.di;

import javax.inject.Singleton;

import dagger.Component;

import gdg.androidtitlan.dagger2_demo.interactors.CategoryInteractor;
import gdg.androidtitlan.dagger2_demo.interactors.InteractorsModule;

@Singleton @Component(
    modules = {
        AppModule.class, InteractorsModule.class
    }) public interface AppComponent {
  void inject(App app);

  CategoryInteractor getFindItemsInteractor();
}
