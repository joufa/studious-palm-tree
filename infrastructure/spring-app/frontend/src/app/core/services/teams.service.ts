import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team, TeamDTO } from '../../teams/models/team';

@Injectable({
  providedIn: 'root',
})
export class TeamsApiService {
  private API_PATH = 'api/teams';

  constructor(private http: HttpClient) {}

  getTeams(): Observable<Team[]> {
      return this.http.get<Team[]>(`${this.API_PATH}`);
  }

  createTeam(team: TeamDTO): Observable<Team> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    return this.http.post<Team>(`${this.API_PATH}`, team, httpOptions);
  }
}
