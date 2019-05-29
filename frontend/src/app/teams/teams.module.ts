import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TeamsPageComponent } from './containers/teams-page.component';
import { TeamsRoutingModule } from './teams-routing.module';
import { StoreModule } from '@ngrx/store';
import { reducers} from './reducers';
@NgModule({
  declarations: [TeamsPageComponent],
  imports: [
    CommonModule,
    TeamsRoutingModule,
    StoreModule.forFeature('teams', reducers),
  ]
})
export class TeamsModule { }
