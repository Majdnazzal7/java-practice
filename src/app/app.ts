
import { Component } from '@angular/core';
import { StudentList } from './components/student-list/student-list';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [StudentList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

}
