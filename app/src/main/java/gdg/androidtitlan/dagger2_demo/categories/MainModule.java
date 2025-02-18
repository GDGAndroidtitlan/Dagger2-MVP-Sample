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
package gdg.androidtitlan.dagger2_demo.categories;

import dagger.Module;
import dagger.Provides;
import gdg.androidtitlan.dagger2_demo.interactors.CategoryInteractor;

@Module public class MainModule {

  private MainView view;

  public MainModule(MainView view) {
    this.view = view;
  }

  @Provides public MainView provideView() {
    return view;
  }

  @Provides
  public MainPresenter providePresenter(MainView mainView, CategoryInteractor categoryInteractor) {
    return new MainPresenterImpl(mainView, categoryInteractor);
  }
}
