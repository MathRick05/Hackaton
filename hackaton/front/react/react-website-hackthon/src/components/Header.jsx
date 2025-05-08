import { FaBars, FaSearch, FaUser } from 'react-icons/fa';

export default function Header() {
  return (
    <header className="bg-[#08294C] flex items-center justify-between px-4 py-3">
      {/* Logo */}
      <div className="flex items-center space-x-2">
        <img src="/logo-biopark.png" alt="Biopark Logo" className="h-8" />
        <span className="text-white font-bold text-xl">BIOPARK</span>
      </div>

      {/* Barra de pesquisa */}
      <div className="flex items-center bg-[#F3EDF7] text-black rounded-full px-3 py-1 w-full max-w-xl">
        <FaBars className="mr-2" />
        <input
          type="text"
          placeholder="Pesquisar Artigo"
          className="bg-transparent flex-grow outline-none"
        />
        <FaSearch />
      </div>

      {/* Botão e ícone de perfil */}
      <div className="flex items-center space-x-4 ml-4">
        <button className="bg-[#FF005C] text-white px-4 py-2 rounded-md font-medium hover:opacity-90 transition">
          Publique seu artigo
        </button>
        <FaUser className="text-white text-xl" />
      </div>
    </header>
  );
}
