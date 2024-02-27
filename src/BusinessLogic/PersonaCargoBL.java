package BusinessLogic;
import java.util.List;

import DataAccess.PersonaCargoDAO;
import DataAccess.DTO.PersonaCargoDTO;
public class PersonaCargoBL {
    
    private PersonaCargoDAO personaCargoDAO = new PersonaCargoDAO();

    public PersonaCargoBL(){}

        public PersonaCargoDTO readBy(Integer id) throws Exception {
        return personaCargoDAO.readBy(id);
    }

    public List<PersonaCargoDTO> readSections(int limit, int offset) throws Exception {
        return personaCargoDAO.readSections(limit, offset);
    }

    public List<PersonaCargoDTO> readAll() throws Exception {
        return personaCargoDAO.readAll();
    }
}
