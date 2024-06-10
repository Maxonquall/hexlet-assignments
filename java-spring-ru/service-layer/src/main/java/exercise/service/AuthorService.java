package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO createAuthor(AuthorCreateDTO authorData) {
        var author = authorMapper.map(authorData);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO getAuthorById(long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        return authorMapper.map(author);

    }

    public AuthorDTO updateAuthor(AuthorUpdateDTO authorData, Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        authorMapper.update(authorData, author);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    // END
}
