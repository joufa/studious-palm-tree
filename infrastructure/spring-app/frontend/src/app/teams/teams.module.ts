import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TeamsPageComponent } from './containers/teams-page.component';
import { TeamsRoutingModule } from './teams-routing.module';
import { StoreModule } from '@ngrx/store';
import { reducers } from './reducers';
import { EffectsModule } from '@ngrx/effects';
import { TeamEffects } from './effects/team.effects';
import { TeamCardComponent } from './components/team-card.component';
import { MaterialModule } from '../core/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AddTeamComponent } from './components/add-team.component';
import { TeamListComponent } from './components/team-list.component';
import { AddTeamsPageComponent } from './containers/add-teams.components';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    TeamsPageComponent,
    TeamCardComponent,
    AddTeamComponent,
    TeamListComponent,
    AddTeamsPageComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule,
    TeamsRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    StoreModule.forFeature('teams', reducers),
    EffectsModule.forFeature([TeamEffects])
  ]
})
export class TeamsModule {}
