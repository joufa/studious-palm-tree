import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TeamsPageComponent } from './containers/teams-page.component';
import { TeamsRoutingModule } from './teams-routing.module';
import { StoreModule } from '@ngrx/store';
import { reducers} from './reducers';
import { EffectsModule } from '@ngrx/effects';
import { TeamEffects } from './effects/team.effects';
import { TeamCardComponent } from './components/team-card.component';
import { MaterialModule } from '../core/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AddTeamComponent } from './components/add-team.component';

@NgModule({
  declarations: [TeamsPageComponent, TeamCardComponent, AddTeamComponent],
  imports: [
    CommonModule,
    MaterialModule,
    TeamsRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    StoreModule.forFeature('teams', reducers),
    EffectsModule.forFeature([TeamEffects]),
  ]
})
export class TeamsModule { }
