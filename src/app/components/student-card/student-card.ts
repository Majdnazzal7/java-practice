
import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Student } from '../../models/student.model';

@Component({
  selector: 'app-student-card',
  standalone: true,
  imports: [],
  templateUrl: './student-card.html',
  styleUrl: './student-card.css'
})
export class StudentCard implements OnChanges {

  @Input() student!: Student;

  ngOnChanges(changes: SimpleChanges): void {
    console.log('Student data changed:', changes);
  }

}
