import {Component, OnInit, ViewChild} from '@angular/core';
import {PaymentService} from "../../services/payment.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit{

  payments :any;
  dataSource :any;
  displayedColumns = ['id','date','amount','type','status','firstName'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort !:MatSort;

    constructor(private paymentService:PaymentService) {
    }
    ngOnInit(): void {
       this.paymentService.paymentList().subscribe({
         next: data =>{
            this.payments = data;
            this.dataSource = new MatTableDataSource(this.payments);
            this.dataSource.paginator = this.paginator;
            this.dataSource.sort = this.sort;
         },
         error :err => {
           console.log(err)
         }
       })
    }

}
