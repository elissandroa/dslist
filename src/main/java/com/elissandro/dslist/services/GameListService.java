package com.elissandro.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elissandro.dslist.dto.GameListDTO;
import com.elissandro.dslist.entities.GameList;
import com.elissandro.dslist.projections.GameMinProjection;
import com.elissandro.dslist.repositories.GameListRepository;
import com.elissandro.dslist.repositories.GameRepository;

@Service
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

	@Transactional
	public void move(Long ListId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(ListId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(ListId, list.get(i).getId(), i);
		}
	}
}
