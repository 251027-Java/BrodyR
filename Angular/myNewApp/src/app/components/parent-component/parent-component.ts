import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChildComponent } from '../child-component/child-component';

@Component({
  selector: 'app-parent-component',
  imports: [CommonModule, FormsModule, ChildComponent],
  templateUrl: './parent-component.html',
  styleUrl: './parent-component.css',
})
export class ParentComponent {
  arr = [1, 2, 3, 4, 5]

  showSurprise(){
    alert("SURPRISE!")
    this.hideElement = !this.hideElement
  }

  hideElement:boolean = true

  nameInput:String = ""
}
