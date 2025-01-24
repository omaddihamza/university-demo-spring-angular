import { Component, OnInit, ViewChild} from '@angular/core';
import {PaymentService} from "../../services/payment.service";
import {ActivatedRoute} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";
import {Payment} from "../../model/payment.model";
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

    dataSource:any;
    firstName!:string;
    lastName!:string;
    payment!:Payment[]
    displayedColumns = ['id','date','amount','type','status','file'];
    @ViewChild(MatPaginator) paginator!:MatPaginator;

    constructor(public paymentService:PaymentService,private route: ActivatedRoute) {
    }



    ngOnInit(): void {
        const code = this.route.snapshot.params['code'];
        this.paymentService.paymentsByStudentList(code).subscribe({
          next:(date:Payment[])=>{
            this.payment = date;
            this.firstName = this.payment[0].student.firstName;
            this.lastName = this.payment[0].student.lastName;
            this.dataSource = new MatTableDataSource(this.payment)
            this.dataSource.paginator = this.paginator;
          },
          error: err => {
            console.log(err)
          }
        })
    }


  downloadFile(id:any) {
    this.paymentService.gePaymentFile(id).subscribe({
      next: (blob: Blob) => {
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = `paymentFile_${id}.pdf`; // Set a filename for the download
        a.click();
        window.URL.revokeObjectURL(url); // Clean up the URL object
      },
      error: (err) => {
        console.error('Error downloading the file', err);
      },
    });
  }
}
