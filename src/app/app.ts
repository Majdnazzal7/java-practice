
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Student } from './models/student.model';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  // Students Array
  students: Student[] = [
    {
      id: 1,
      name: 'Majd',
      age: 22,
      email: 'majd@gmail.com',
      isActive: true
    },
    {
      id: 2,
      name: 'Ahmad',
      age: 24,
      email: 'ahmad@gmail.com',
      isActive: false
    }
  ];

  // Object for Add and Edit Form
  newStudent: Student = {
    id: 0,
    name: '',
    age: 0,
    email: '',
    isActive: true
  };

  // Edit State
  isEditing: boolean = false;
  editingStudentId: number | null = null;

  // Add Student
  addStudent(): void {

    const student: Student = {
      id: this.students.length + 1,
      name: this.newStudent.name,
      age: this.newStudent.age,
      email: this.newStudent.email,
      isActive: true
    };

    this.students.push(student);

    this.cancelEdit();
  }

  // Delete Student
  deleteStudent(id: number): void {

    this.students = this.students.filter(
      student => student.id !== id
    );

  }

  // Edit Student
  editStudent(student: Student): void {

    this.isEditing = true;
    this.editingStudentId = student.id;

    this.newStudent = {
      id: student.id,
      name: student.name,
      age: student.age,
      email: student.email,
      isActive: student.isActive
    };

  }

  // Update Student
  updateStudent(): void {

    const student = this.students.find(
      s => s.id === this.editingStudentId
    );

    if (student) {
      student.name = this.newStudent.name;
      student.age = this.newStudent.age;
      student.email = this.newStudent.email;
    }

    this.cancelEdit();

  }

  // Cancel Edit and Reset Form
  cancelEdit(): void {

    this.isEditing = false;
    this.editingStudentId = null;

    this.newStudent = {
      id: 0,
      name: '',
      age: 0,
      email: '',
      isActive: true
    };

  }

}
