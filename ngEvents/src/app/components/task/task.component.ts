import { TaskService } from './../../services/task.service';
import { Task } from './../../models/task';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  tasks: Task[] = [];

  selected: Task = null;


  constructor(
    private taskSvc: TaskService,
    private currentRoute: ActivatedRoute,
    private router: Router) { }


  ngOnInit(): void {
    this.reload();
  }

  reload(){
    this.taskSvc.index().subscribe(
      data => {
        return this.tasks = data;
      },
      err => {
        return console.error('Observer got an error: ' + err);
      }
    );
  }


}
