import { Component, signal, WritableSignal } from '@angular/core';
import { Pokemon } from '../../services/pokemon';
import { CommonModule, TitleCasePipe } from '@angular/common';
import { PokemonInterface } from '../../interfaces/pokemon-interface';

@Component({
  selector: 'app-catch',
  imports: [TitleCasePipe, CommonModule],
  templateUrl: './catch.html',
  styleUrl: './catch.css',
})
export class Catch {
  constructor(private pokemonService:Pokemon){}

  pokemon:WritableSignal<PokemonInterface> = signal({id:0, name:"", sprite:""});

  ngOnInit(){
    this.getPokemon()
  }

  getPokemon(){
    this.pokemonService.getPokemon().subscribe(data => {
      console.log(data)
      this.pokemon.set(data)
    })
  }

  catchPokemon(){
    this.pokemonService.caughtPokemon.push(this.pokemon())
    alert("Caught " + this.pokemon().name)
    this.pokemon.set({id:0, name:"", sprite:""})
  }
}
