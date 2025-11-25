import { Component } from '@angular/core';
import { Pokemon } from '../../services/pokemon';

@Component({
  selector: 'app-catch',
  imports: [],
  templateUrl: './catch.html',
  styleUrl: './catch.css',
})
export class Catch {
  constructor(private pokemonService:Pokemon){}

  pokemon:any = {}

  ngOnInit(){
    this.getPokemon()
  }

  getPokemon(){
    this.pokemonService.getPokemon().subscribe(data => {
      console.log(data)
      this.pokemon = data
    })
  }
}
