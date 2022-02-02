package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {
	@Autowired
	private EpisodeRepository episodeRepository;
	public  EpisodeServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addEpisode(Episode episode) {
		// TODO Auto-generated method stub
		Episode episode2 =  episodeRepository.save(episode);
		if (episode2!=null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}

	@Override
	public Optional<Episode> getEpisodeById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return episodeRepository.findById(id);
	}

	@Override
	public Episode[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Episode> list = episodeRepository.findAll();
		Episode[] array = new Episode[list.size()];
		return episodeRepository.findAll().toArray(array);
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Episode> optional = this.getEpisodeById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("User not found");
			}
			else {
				episodeRepository.deleteById(id);
				return "successfully deleted episode";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Episode>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodeRepository.findAll());
	}

	@Override
	public String modifyEpisode(String id, Episode episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}