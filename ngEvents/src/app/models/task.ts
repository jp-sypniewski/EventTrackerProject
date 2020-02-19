export class Task {

  id: number;
  name: string;
  status: string;
  dueDate: Date;
  createdAt: Date;
  updatedAt: Date;

  constructor(id?: number, name?: string, status?: string, dueDate?: Date, createdAt?: Date, updatedAt?: Date){
    this.id = id;
    this.name = name;
    this.status = status;
    this.dueDate = dueDate;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}
