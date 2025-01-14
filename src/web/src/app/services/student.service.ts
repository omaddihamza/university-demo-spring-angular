import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";
import {Student} from "../model/student.model";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http:HttpClient) { }
  url = environment.backendHost;
  studentList():Observable<Student[]>{
    return this.http.get<Student[]>(this.url+"students")
  }
}
