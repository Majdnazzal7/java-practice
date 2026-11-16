
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { StudentCard } from '../student-card/student-card';
import { Student } from '../../models/student.model';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [StudentCard, FormsModule],
  templateUrl: './student-list.html',
  styleUrl: './student-list.css'
})
export class StudentList {

  students: Student[] = [
    {
      id: 1,
      name: 'Ahmad',
      age: 22,
      email: 'ahmad@gmail.com',
      grade: 'A'
    },
    {
      id: 2,
      name: 'Sara',
      age: 21,
      email: 'sara@gmail.com',
      grade: 'B'
    },
    {
      id: 3,
      name: 'Majd',
      age: 23,
      email: 'majd@gmail.com',
      grade: 'A+'
    }
  ];

  newStudent: Student = this.createEmptyStudent();

  editingId: number | null = null;

  createEmptyStudent(): Student {
    return {
      id: 0,
      name: '',
      age: 0,
      email: '',
      grade: ''
    };
  }

  addStudent(): void {
    const student: Student = {
      ...this.newStudent,
      id: Date.now()
    };

    this.students.push(student);
    this.newStudent = this.createEmptyStudent();
  }

  editStudent(student: Student): void {
    this.newStudent = { ...student };
    this.editingId = student.id;
  }

  updateStudent(): void {
    this.students = this.students.map(student =>
      student.id === this.editingId
        ? { ...this.newStudent, id: student.id }
        : student
    );

    this.cancelEdit();
  }

  deleteStudent(id: number): void {
    this.students = this.students.filter(student => student.id !== id);
  }

  cancelEdit(): void {
    this.newStudent = this.createEmptyStudent();
    this.editingId = null;
  }

}
