import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TeamsPageComponent } from './containers/teams-page.component';


const routes: Routes = [
  {
    path: '',
    component: TeamsPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeamsRoutingModule { }
