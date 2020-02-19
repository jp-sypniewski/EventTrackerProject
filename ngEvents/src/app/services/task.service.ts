import { Task } from './../models/task';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseUrl = 'http://localhost:8080/';
  private url = this.baseUrl + 'api/teams/1/tasks';

  tasks: Task[] = [];

  constructor(private http: HttpClient) { }

  index(){
    return this.http.get<Task[]>(this.url)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM goes the index method');
      })
    );
  }

  create(task) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    return this.http.post<Task>(this.url, task, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM goes the create method');
        })
      );
  }

  destroy(id) {
    return this.http.delete<Task>(this.url + '/' + id)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM goes the destroy method');
        })
      )
  }

  update(task) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    return this.http.put<Task>(this.url + '/' + task.id, task, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM goes the update method');
        })
      )
  }


}
