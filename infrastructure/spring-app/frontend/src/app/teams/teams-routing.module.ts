import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTeamsPageComponent } from './containers/add-teams.components';
import { TeamsPageComponent } from './containers/teams-page.component';

const routes: Routes = [
  {
    path: '',
    component: TeamsPageComponent
  },
  { path: 'new', component: AddTeamsPageComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeamsRoutingModule {}
