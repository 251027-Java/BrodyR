import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { PokemonInterface } from '../interfaces/pokemon-interface';

@Injectable({
  providedIn: 'root',
})
export class Pokemon {

  caughtPokemon:PokemonInterface[] = []

  constructor(private http:HttpClient){}

  getPokemon():Observable<PokemonInterface>{
    const randomNum = Math.floor(Math.random() * 1025) + 1
    return this.http.get<PokemonInterface>(`https://pokeapi.co/api/v2/pokemon/${randomNum}`).pipe(
      map<any, PokemonInterface>(data => ({
        id:data.id,
        name:data.name,
        sprite:data.sprites.front_default
      }))
    )
  }
}
