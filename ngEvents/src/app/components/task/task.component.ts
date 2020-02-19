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

  editTask: Task = null;

  newTask: Task = new Task();


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
  onSubmitNew(){
    this.taskSvc.create(this.newTask).subscribe(
      data => {
        this.newTask = new Task();
        return this.reload();
      },
      err => {
        return console.error('Observer got an error: ' + err);
      }
    );
  }

  onSubmitEdit(){
    this.taskSvc.update(this.editTask).subscribe(
      data => {
        this.selected = data;
        this.editTask = null;
        return this.reload();
      },
      err => {
        return console.error('Observer got an error: ' + err);
      }
    );
  }

  deleteTodo(id){
    this.taskSvc.destroy(id).subscribe(
      data => {
        this.selected = null;
        this.editTask = null;
        return this.reload();
      },
      err => {
        return console.error('Observer got an error: ' + err);
      }
    );
  }
}
