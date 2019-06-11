package com.example.sintomedic.repositorios;

        import com.example.sintomedic.Usuario;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuario, Long> {


}
