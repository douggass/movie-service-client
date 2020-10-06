package com.movie.task;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.movie.client.MovieClientSocket;
import com.movie.dto.Input;
import com.movie.dto.Output;
import com.movie.utils.Mapper;

@RunWith(MockitoJUnitRunner.class)
public class MovieTaskTest {

	@InjectMocks
	private MovieTask movieTask;

	@Mock
	private Mapper mapper;

	@Mock
	private MovieClientSocket movieClientSocket;

	@Test
	public void findMoviesTest() throws JsonProcessingException {
		
		final String query = "Game of Th";
		final XmlMapper xmlMapper = new XmlMapper();
		
		final Input input = Input.builder()
				.query(query)
				.length(query.length())
				.build();
		final String xmlInput = xmlMapper.writeValueAsString(input);
		when(mapper.toXml(input)).thenReturn(xmlInput);
		final String outputXml = xmlMapper.writeValueAsString(input);
		final Output output = Output.builder().build();
		when(mapper.fromXml(outputXml)).thenReturn(output);
		when(movieClientSocket.findMovies(xmlInput)).thenReturn(outputXml);
		
		movieTask.findMovies(query);

		verify(movieClientSocket, times(1)).findMovies(xmlInput);
		verify(mapper, times(1)).toXml(input);
		verify(mapper, times(1)).fromXml(outputXml);
		
	}

}
