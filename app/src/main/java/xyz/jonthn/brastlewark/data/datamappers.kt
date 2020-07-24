package xyz.jonthn.brastlewark.data

import xyz.jonthn.brastlewark.data.database.Inhabitant as RoomInhabitant
import xyz.jonthn.domain.Inhabitant as DomainInhabitant
import xyz.jonthn.brastlewark.data.server.Brastlewark as ServerInhabitant

fun DomainInhabitant.toRoomInhabitant(): RoomInhabitant =
    RoomInhabitant(id, age, friends, hair_color, height, name, professions, thumbnail, weight)

fun RoomInhabitant.toDomainInhabitant(): DomainInhabitant =
    DomainInhabitant(age, friends, hair_color, height, id, name, professions, thumbnail, weight)

fun ServerInhabitant.toDomainInhabitant(): DomainInhabitant =
    DomainInhabitant(age, friends, hair_color, height, id, name, professions, thumbnail, weight)