package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;


    public SalaService(SalaRepository salaRepository, SalaMapper salaMapper){
        this.salaRepository = salaRepository;
        this.salaMapper = salaMapper;
    }

    public List<SalaResponseDTO> buscarSalasAtivas(){
        List<Sala> salas = salaRepository.buscarSalasAtivas();

        return salaMapper.toResponseDTO(salas);
    }

    public Optional<SalaResponseDTO> buscarSalaAtivaPorId(Long id){
        Optional<Sala> sala = salaRepository.buscarSalaAtivaPorId(id);

        return sala.map(salaMapper::toResponseDTO);
    }


}
