import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Pokemon } from '../../services/pokemon';

@Component({
  selector: 'app-dashboard',
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {
  constructor(public pokemonService:Pokemon){}
}
