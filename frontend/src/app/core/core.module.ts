import { NgModule } from '@angular/core';

import { MaterialModule } from './material';
import { AppComponent } from './containers/app.component';
import { RouterModule } from '@angular/router';

export const COMPONENTS = [
  AppComponent
];

@NgModule({
  declarations: [COMPONENTS],
  imports: [
    RouterModule,
    MaterialModule
  ],
  exports: [COMPONENTS]
})
export class CoreModule { }
