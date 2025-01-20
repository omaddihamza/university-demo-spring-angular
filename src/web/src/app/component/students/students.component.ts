import {Component, OnInit, ViewChild} from '@angular/core';
import {StudentService} from "../../services/student.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {Student} from "../../model/student.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit{
  students!:Student[];
  dataSource :any;
  displayedColumns = ['id','firstName','lastName','code','programId','payment'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private studentService:StudentService, private router:Router, private route:ActivatedRoute) {
  }
    ngOnInit(): void {
       this.studentService.studentList().subscribe({
         next:data=>{
            this.students = data;
            this.dataSource = new MatTableDataSource(this.students);
            this.dataSource.paginator = this.paginator;
            this.dataSource.sort = this.sort;
         },
         error :err => {
           console.log(err)
         }
       })
    }


  PaymentByStudent() {

    this.router.navigate(['/admin/students/student-details']);
  }
}
